package com.ws.client;

import java.rmi.RemoteException;

import com.ws.bean.BeanLogin;
import com.ws.service.ImplLogin;
import com.ws.service.ImplLoginProxy;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplLogin Iface = new ImplLoginProxy("http://localhost:8080/ValidaCredenciales2/services/ImplLogin");
		BeanLogin obj = new BeanLogin();
		obj.setUsuario("Gabriel");
		obj.setPassword("secret123");
		try {
			obj = Iface.validaLogin(obj);
			if(obj.getStatus()) {
				System.out.println("Bienvenido " + obj.getUsuario());
			}else {
				System.out.println(obj.getMensaje());
			}
		}catch(RemoteException re) {
			re.printStackTrace();
		}
	}
}
