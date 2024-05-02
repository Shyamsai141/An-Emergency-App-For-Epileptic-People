package com.example.original;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Objects;

public class Medicalreport extends AppCompatActivity {

    private static final int STORAGE_PERMISSION_REQUEST_CODE = 100;
    private static final int SELECT_PDF_REQUEST_CODE = 86;

    private ImageView selectfile;
    private ImageView uploadfile;
    private TextView notification;
    private FirebaseStorage storage;
    private FirebaseDatabase database;
    private ProgressDialog progressDialog;
    private Toolbar toolbar;
    private Uri pdfUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        setContentView(R.layout.activity_medicalreport);

        // Initialize views
        selectfile = findViewById(R.id.selectfile);
        uploadfile = findViewById(R.id.upload);
        notification = findViewById(R.id.notification);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Medical Report");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        storage = FirebaseStorage.getInstance();
        database = FirebaseDatabase.getInstance();

        // File selection
        selectfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(
                        Medicalreport.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                        == PackageManager.PERMISSION_GRANTED) {
                    selectPDF();
                } else {
                    ActivityCompat.requestPermissions(
                            Medicalreport.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            STORAGE_PERMISSION_REQUEST_CODE
                    );
                }
            }
        });

        // File uploading
        uploadfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pdfUri != null) {
                    uploadPDF(pdfUri);
                } else {
                    Toast.makeText(
                            Medicalreport.this,
                            "Please select a file",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
    }

    // Upload PDF file
    private void uploadPDF(Uri pdfUri) {
        if (pdfUri == null) {
            Toast.makeText(
                    this,
                    "Please select a file before uploading",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading file...");
        progressDialog.setProgress(0);
        progressDialog.show();

        final String fileName = System.currentTimeMillis() + "";
        StorageReference storageReference = storage.getReference();
        StorageReference uploadPath = storageReference.child("Uploads").child(fileName);

        uploadPath.putFile(pdfUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(
                                Medicalreport.this,
                                "File successfully uploaded",
                                Toast.LENGTH_SHORT
                        ).show();
                        progressDialog.dismiss();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(
                                Medicalreport.this,
                                "File upload failed",
                                Toast.LENGTH_SHORT
                        ).show();
                        progressDialog.dismiss();
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                        int progress = (int) ((100 * taskSnapshot.getBytesTransferred())
                                / taskSnapshot.getTotalByteCount());
                        progressDialog.setProgress(progress);
                    }
                });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == STORAGE_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                selectPDF();
            } else {
                Toast.makeText(this, "Please provide storage permissions",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void selectPDF() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("application/pdf");
        startActivityForResult(intent, SELECT_PDF_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SELECT_PDF_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            pdfUri = data.getData();
            Toast.makeText(
                    this,
                    "File selected",
                    Toast.LENGTH_SHORT
            ).show();
        } else {
            Toast.makeText(
                    this,
                    "Please select a file",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
}
