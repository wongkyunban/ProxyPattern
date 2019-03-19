package impl;

import inter.MyRemote;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    public MyRemoteImpl() throws RemoteException{}

    @Override
    public String sayHello() throws RemoteException {
        return "Server says, 'Hello'";
    }


    public static void main(String[] args){
        try{
            MyRemote myRemote = new MyRemoteImpl();  //先产生远程对象
            Naming.rebind("RemoteHello",myRemote);//再使用Naming.rebind()绑定到rmiregistry，客户将使用我们所注册的名称RemoteHello在RMI registry中寻找他。
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
