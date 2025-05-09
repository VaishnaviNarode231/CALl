package com.vn1.pp;

import org.hibernate.cfg.Configuration;

import com.mysql.cj.xdevapi.SessionFactory;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Contaact project" );
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        System.out.println(factory);

    }
}
