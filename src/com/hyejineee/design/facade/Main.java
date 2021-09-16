package com.hyejineee.design.facade;

public class Main {
    public static void main(String[] args) {

        //파사드 패턴을 사용하지 않을 경우, 필요한 클래스를 일일히 다 가져와 써야함.
        Ftp ftp = new Ftp("www.foo.co.kr", 22, "homt/etc");
        ftp.connect();
        ftp.moveDirectory();

        Writer w = new Writer("text.txt");
        w.fileConnect();
        w.write();

        Reader r = new Reader("text.txt");
        r.fileConnect();
        r.fileRead();

        r.fileDisconnect();
        w.fileDisconnect();
        ftp.disConnect();


        //객체를 한 번 감싸고 의존성을 SftpClient로 다 가져가게 하고, 새로운 인터페이스를 제공함.
        SftpClient sftpClient = new SftpClient("www.foo.co.kr", 22, "home/etc", "temp.txt");
        sftpClient.connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disconnect();



    }

}
