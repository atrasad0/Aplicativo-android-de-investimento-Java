package com.topicosavancados.investimentoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botaoCalcularListener();
    }

    public void botaoCalcularListener(){
        Button btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirAtividade2(); //segunda atividade contem o algoritmo e a lista
            }
        });
    }

    public void abrirAtividade2(){
        Intent intent = new Intent(this, algoritmoLista.class);
        //recebendo parametros a serem enviados
        EditText txtValorMensal = (EditText) findViewById(R.id.txtValorMensal);
        EditText txtValorCiclo = (EditText) findViewById(R.id.txtValorCiclo);
        EditText  txtQtdMesesInvestimento = (EditText) findViewById(R.id.txtQtdMesesInvestimento);
        EditText  txtQtdMesesUmCiclo = (EditText) findViewById(R.id.txtQtdMesesUmCiclo);
        EditText  txtPorcRetorno = (EditText) findViewById(R.id.txtPorcRetorno);
        EditText  txtSaldoInicial = (EditText) findViewById(R.id.txtSaldoInicial);

        //convertendo os parametros
        try {
            double valorMensal = Double.parseDouble(txtValorMensal.getText().toString());
            double valorCiclo = Double.parseDouble(txtValorCiclo.getText().toString());
            int qtdMesesInvestimento = Integer.parseInt(txtQtdMesesInvestimento.getText().toString());
            int qtdMesesUmCiclo = Integer.parseInt(txtQtdMesesUmCiclo.getText().toString());
            double qtdPorcRetorno = Double.parseDouble(txtPorcRetorno.getText().toString());
            double saldoInicial = Double.parseDouble(txtSaldoInicial.getText().toString());

            //enviando parametros para atividade 2
            Bundle parametros = new Bundle();
            parametros.putDouble("valor_mensal",valorMensal);
            parametros.putDouble("valor_ciclo",valorCiclo);
            parametros.putInt("qtd_meses_investimento",qtdMesesInvestimento);
            parametros.putInt("qtd_meses_ciclo",qtdMesesUmCiclo);
            parametros.putDouble("qtd_porc_retorno",qtdPorcRetorno);
            parametros.putDouble("saldo_inicial",saldoInicial);

            intent.putExtras(parametros);
            startActivity(intent);

        }catch (IllegalArgumentException eArgumento){
            Toast.makeText(getApplicationContext(),"Preencha os valores corretamente!", Toast.LENGTH_SHORT).show();
        }



    }
}
