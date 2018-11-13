/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.ModelMessage;
import views.ViewMessage;
/**
 *
 * @author LENOVO
 */
public class ControllerMessage implements ActionListener {
    ModelMessage modelMessage;
    ViewMessage viewMessage;
    
    public ControllerMessage(ViewMessage viewMessage, ModelMessage modelMessage){
        this.viewMessage = viewMessage;
        this.modelMessage = modelMessage;
        viewMessage.jb_calcular.addActionListener(this);
        initComponents();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewMessage.jb_calcular){
            jb_calcular();
    }   
}
    public void jb_calcular(){
        float peso= 0.0f;
        float estatura= 0.0f;
        float imc= 0.0f;
        
        modelMessage.setPeso(viewMessage.jtf_peso.getText());
        modelMessage.setAltura(viewMessage.jtf_estatura.getText());
        modelMessage.setImc(viewMessage.jtf_imc.getText());
        
        peso = Float.parseFloat(viewMessage.jtf_peso.getText());
        estatura = Float.parseFloat(viewMessage.jtf_estatura.getText());
         
        imc = peso/(estatura*estatura);
        if ((peso < 5) || (peso >200) || (estatura<1.50) || (estatura> 2)){
            JOptionPane.showMessageDialog(null, "Error Al ingresar Datos" );
        }
        else{
            if (imc<=5){
                viewMessage.jl_mensaje.setText("Delgadez 3");
                }
            else if ((imc>5) && (imc<=10)) {
                viewMessage.jl_mensaje.setText("Delgadez 2");
            }
            else if ((imc>10) && (imc<=18.50)) {
                viewMessage.jl_mensaje.setText("Delgadez 1");
            }
            else if ((imc>18.50) && (imc<=24.99)) {
                viewMessage.jl_mensaje.setText("Peso Normal");
            }
            else if ((imc>25) && (imc<=29.99)) {
                viewMessage.jl_mensaje.setText("Sobrepeso");
            }
            else if ((imc>30) && (imc<=34.99)) {
                viewMessage.jl_mensaje.setText("Obesidad grado 1");
            }
            else if ((imc>35) && (imc<=40)) {
                viewMessage.jl_mensaje.setText("Obesidad grado 2");
            }
            else  if(imc>40) {
                viewMessage.jl_mensaje.setText("Obesidad grado 3");
            }
        viewMessage.jtf_imc.setText(String.valueOf(imc));
    }
    }
    public final void initComponents(){
        viewMessage.setVisible(true);
        viewMessage.jtf_imc.setText(modelMessage.getImc());
    }
}
