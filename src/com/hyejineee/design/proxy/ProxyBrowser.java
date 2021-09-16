package com.hyejineee.design.proxy;

public class ProxyBrowser implements IBrowser {

    private String url;
    private Html html;

    public ProxyBrowser(String url){
        this.url = url;
    }

    @Override
    public Html show() {

        if(this.html == null){
            this.html = new Html(url);
            System.out.println("proxy browser loading html from :" + url);
        }
        System.out.println("proxy browser use cache html");
        return this.html;
    }
}
