package local.bunayari.jualankopi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

//materi yang dipelajari
//btn-setOnClickListener, toast(message pop up), checkbox-setOnCheckedChangeListener
public class MainActivity extends AppCompatActivity {
    //DEKLARASI VARIABEL
    TextView jumlahKopi, totalKopi; //alertKopi;
    Button btnOrder;
    int kopi, hargaKopi = 15000;
    CheckBox susu, cream, sliceOfChoco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //PEMBACAAN INTERFACE DI XML
        totalKopi = (TextView) findViewById(R.id.totalKopi);
        jumlahKopi = (TextView) findViewById(R.id.jumlahKopi);
        susu = (CheckBox) findViewById(R.id.susu);
        cream = (CheckBox) findViewById(R.id.cream);
        sliceOfChoco = (CheckBox) findViewById(R.id.sliceofchoco);
        btnOrder = (Button) findViewById(R.id.btnOrder);
        //alertKopi = (TextView) findViewById(R.id.alertKopi);


        //LISTEN JML_KOPI DIKALIKAN HARGA KOPI DENGAN PERCABANGAN
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Di sini kita memasukkan fungsi yang kita inginkan saat menekan tombol 'btnOrder'.
                if (jumlahKopi.getText().equals("0")){
                    totalKopi.setText("Rp. 0");
                    Toast.makeText(MainActivity.this, "Mohon maaf, Anda belum menentukan jumlah kopi yang ingin dipesan.", Toast.LENGTH_SHORT).show();


                } else {
                    String sKopi = "Rp. " + (kopi * hargaKopi);
                    totalKopi.setText(sKopi); //Di sini kita menetapkan hasil tampilan dari jumlah kopi yang dikalikan harga kopi.
                    Toast.makeText(MainActivity.this, "Order Berhasil!\n", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //CHECKBOX ADD-ONS SUSU
        susu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(susu.isChecked()){
                    hargaKopi = hargaKopi + 5000;
                } else {
                    hargaKopi = hargaKopi - 5000;
                }
            }
        });


                //CHECKBOX ADD-ONS CREAM
        cream.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cream.isChecked()){
                    hargaKopi = hargaKopi + 3000;
                } else {
                    hargaKopi = hargaKopi - 3000;
                }
            }
        });

        //CHECKBOX ADD-ONS SLICE OF CHOCO
        sliceOfChoco.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(sliceOfChoco.isChecked()){
                    hargaKopi = hargaKopi + 7000;
                } else {
                    hargaKopi = hargaKopi - 7000;
                }
            }
        });
    }
//
//    public void submitOrder(View v){
//        tampilKopi(0);
//    }

    public void tampilKopi(int number){
        jumlahKopi.setText(number+""); //DIBACA STRING; BIS PAKE CAST/CONVERT
    }

    public void tambahKopi(View v){
        kopi = kopi + 1;
        if (kopi > 0){
            susu.setEnabled(true);
            cream.setEnabled(true);
            sliceOfChoco.setEnabled(true);
        }
        tampilKopi(kopi);
    }

    public void kurangKopi(View v){
        if (kopi > 0 )
            kopi = kopi - 1;
            if (kopi == 0){
                susu.setEnabled(false);
                cream.setEnabled(false);
                sliceOfChoco.setEnabled(false);
            }
            tampilKopi(kopi);

    }

    public void tambahSusu(View v){
        susu.setEnabled(false);

    }

    public void tambahCream(View v){
        cream.setEnabled(false);

    }

    public void tambahSliceOfChoco(View v){
        sliceOfChoco.setEnabled(false);
    }
}

