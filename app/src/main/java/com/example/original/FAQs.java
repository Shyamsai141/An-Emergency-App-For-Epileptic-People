package com.example.original;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class FAQs extends AppCompatActivity {
    private ListView faqListView;
    Toolbar toolbar;
    private String[] questions = {
            "What is epilepsy? What is a seizure?",
            "How long do seizures usually last?",
            "What are the major types of seizures?",
            "If I have a seizure, does that mean I have epilepsy?",
            "What causes epilepsy?",
            "Is epilepsy common?",
            "How can I prevent epilepsy?",
            "How is epilepsy diagnosed?",
            "What can I do to manage my epilepsy?",
            "Can a person die from epilepsy?"
    };

    private String[] answers = {
            "Epilepsy, which is sometimes called a seizure disorder, is a disorder of the brain. A person is diagnosed with epilepsy when they have had two or more seizures.\n" +
                    "\n" +
                    "A seizure is a short change in normal brain activity.\n" +
                    "\n" +
                    "Seizures are the main sign of epilepsy. Some seizures can look like staring spells. Other seizures cause a person to fall, shake, and lose awareness of what’s going on around them.",

            "Usually, a seizure lasts from a few seconds to a few minutes. It depends on the type of seizure.",

            "Sometimes it is hard to tell when a person is having a seizure. A person having a seizure may seem confused or look like they are staring at something that isn’t there. Other seizures can cause a person to fall, shake, and become unaware of what’s going on around them.\n" +
                    "\n" +
                    "Seizures are classified into two groups.\n" +
                    "Generalized seizures affect both sides of the brain.\n" +
                    "Focal seizures affect just one area of the brain. These seizures are also called partial seizures.",

            "Not always. Seizures can also happen because of other medical problems. These problems include:\n" +
                    "\n" +
                    "A high fever.\n" +
                    "Low blood sugar.\n" +
                    "Alcohol or drug withdrawal.",

            "Epilepsy can be caused by different conditions that affect a person’s brain. Some known causes include:\n" +
                    "\n" +
                    "Stroke.\n" +
                    "Brain tumor.\n" +
                    "Brain infection from parasites (malaria, neurocysticercosis), viruses (influenza, dengue, Zika), and bacteria.\n" +
                    "Traumatic brain injury or head injury.\n" +
                    "Loss of oxygen to the brain (for example, during birth).\n" +
                    "Some genetic disorders (such as Down syndrome).\n" +
                    "Other neurologic diseases (such as Alzheimer’s disease).\n" +
                    "For 2 in 3 people, the cause of epilepsy is unknown. This type of epilepsy is called cryptogenic or idiopathic.",

            "Epilepsy is one of the most common conditions affecting the brain.\n" +
                    "\n" +
                    "When counting both children and adults in the United States:\n" +
                    "About 5.1 million people in the United States have a history of epilepsy.\n" +
                    "About 3.4 million people in the United States have active epilepsy.",

            "Sometimes we can prevent epilepsy. These are some of the most common ways to reduce your risk of developing epilepsy:\n" +
                    "\n" +
                    "Have a healthy pregnancy. Some problems during pregnancy and childbirth may lead to epilepsy. Follow a prenatal care plan with your health care provider to keep you and your baby healthy.\n" +
                    "Prevent brain injuries.\n" +
                    "Lower the chances of stroke and heart disease.\n" +
                    "Be up-to-date on your vaccinations.\n" +
                    "Wash your hands and prepare food safely to prevent infections such as cysticercosis.",

            "A person who has a seizure for the first time should talk to a health care provider, such as a doctor or nurse practitioner. The provider will talk to the person about what happened, and look for the cause of the seizure. Many people who have seizures take tests such as brain scans for a closer look at what is going on. These tests do not hurt.",

            "Self-management is what you do to take care of yourself. You can learn how to manage seizures and keep an active and full life. Begin with these tips:\n" +
                    "\n" +
                    "Take your medicine.\n" +
                    "Talk with your doctor or nurse when you have questions.\n" +
                    "Recognize seizure triggers (such as flashing or bright lights).\n" +
                    "Keep a record of your seizures.\n" +
                    "Get enough sleep.\n" +
                    "Lower stress.",

            "Most people with epilepsy live a full life. However, the risk of early death is higher for some. We know that the best possible seizure control and living safely can reduce the risk of epilepsy-related death.\n" +
                    "\n" +
                    "Factors that increase the risk of early death include:\n" +
                    "\n" +
                    "More serious health problems, such as a stroke or a tumor. These conditions carry an increased risk of death and may cause seizures.\n" +
                    "Falls or other injuries that happen because of seizures. These injuries can be life-threatening.\n" +
                    "Seizures that last over 5 minutes. This is a condition called status epilepticus. Status epilepticus can sometimes happen when a person suddenly stops taking seizure medication.\n" +
                    "Rarely, people with epilepsy can experience sudden unexpected death in epilepsy (SUDEP). SUDEP is not well understood and experts don’t know what causes it, but they suspect that it is sometimes due to a change in heart beats (rhythm) during a seizure. Sudden death due to heart rhythm changes also happens in people who do not have seizures.\n" +
                    "\n" +
                    "The risk of sudden death is larger for people with major uncontrolled seizures."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Hide the notification bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_faqs);

        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("FAQ's");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        faqListView = findViewById(R.id.faqListView);
        faqListView.setAdapter(new FAQAdapter());

        faqListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Toggle visibility of answer
                TextView answerView = view.findViewById(R.id.answerTextView);
                if (answerView.getVisibility() == View.VISIBLE) {
                    answerView.setVisibility(View.GONE);
                } else {
                    answerView.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private class FAQAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return questions.length;
        }

        @Override
        public Object getItem(int position) {
            return questions[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.activity_faqs2, parent, false);
            }

            TextView questionTextView = convertView.findViewById(R.id.questionTextView);
            TextView answerTextView = convertView.findViewById(R.id.answerTextView);

            // Adding numbering to the question
            String numberedQuestion = (position + 1) + ") " + questions[position];
            questionTextView.setText(numberedQuestion);
            answerTextView.setText(answers[position]);

            return convertView;
        }

    }
}