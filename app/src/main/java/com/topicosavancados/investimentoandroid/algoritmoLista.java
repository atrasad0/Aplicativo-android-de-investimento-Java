package com.topicosavancados.investimentoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class algoritmoLista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algoritmo_lista);
        carregaLista();
    }

    public void carregaLista(){
        ListView listInvestimento = (ListView) findViewById(R.id.listInvestimento);
        List<String> listResultado = new ArrayList<String>();

        Intent intent = getIntent();
        Bundle parametros = intent.getExtras();

        if(parametros != null) {
            //parametros digitado pelo usuario
            double valorMensal = parametros.getDouble("valor_mensal");
            double valorCiclo = parametros.getDouble("valor_ciclo");
            int qtdMesesInvestimento = parametros.getInt("qtd_meses_investimento");
            int qtdMesesUmCiclo = parametros.getInt("qtd_meses_ciclo");
            double qtdPorcRetorno = parametros.getDouble("qtd_porc_retorno");
            double saldoInicial = parametros.getDouble("saldo_inicial");

            int cont = 0;//variavel que controla a se chegou a qtd meses de um cilco
            double jurosSobreSaldo;
            DecimalFormat f = new DecimalFormat("#.##");
            //algoritmo investimento
            for (int i = 0; i < qtdMesesInvestimento; i++){
                cont++;
                saldoInicial = saldoInicial + saldoInicial*(qtdPorcRetorno/100);
                jurosSobreSaldo = saldoInicial * (qtdPorcRetorno/100);
                saldoInicial  = saldoInicial  + valorMensal;
                if (cont == qtdMesesUmCiclo){
                    saldoInicial = saldoInicial + valorCiclo;
                    cont = 0;
                }
                //populando a lista
                listResultado.add("Mes: " + (i+1) + " Juros Sobre o saldo: R$" + f.format(jurosSobreSaldo)  + " - " + "Saldo: R$" + f.format(saldoInicial));

            }
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listResultado);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            listInvestimento.setAdapter(dataAdapter);
        }







    }
}
