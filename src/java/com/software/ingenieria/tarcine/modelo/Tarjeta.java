/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.software.ingenieria.tarcine.modelo;

import java.util.Random;

public class Tarjeta {

    private int id;private long saldo;
    private String codTarjeta;

    public Tarjeta(int id, int saldo) {
        this.id = id;

        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    public void setCod(String cod){
        this.codTarjeta = cod;
    }
    public String getCod(){
        return this.codTarjeta;
    }
    public void generadorCodTarjeta() {
        Random r = new Random();
        String l = "abcdefghijklmnopqrstuvwxyz";
        String alphabet = l.toUpperCase();
        String cod = "";
        for (int i = 0; i < 3; i++) {
           cod += String.valueOf(alphabet.charAt(r.nextInt(alphabet.length())));
        }
        this.codTarjeta =  cod + (int) Math.floor(Math.random() * (30000 - 10000 + 1) + 10000);
    }
}
