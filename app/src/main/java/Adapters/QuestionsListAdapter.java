package Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.pkmmte.view.CircularImageView;
import com.squareup.picasso.Picasso;
import com.tech.club.MainActivity;
import com.tech.club.Ques;
import com.tech.club.R;
import com.tech.club.RoundTransform;

import java.util.List;

import Data.SetterGetterQuestions;

/**
 * Created by Home on 23-03-2015.
 */
public class QuestionsListAdapter  extends BaseAdapter{


    List<SetterGetterQuestions> setterGetterQuestionsList=null;
    Context context;
    static TextView user;
    static TextView time;
    static TextView count;
    private String questionTime;
    private String questionCount;
    private String questionsUser;
    private String questionUserImage;
    private CircularImageView image;


    public QuestionsListAdapter(Context context, List<SetterGetterQuestions> setterGetterQuestionsList) {


    this.context=context;
    this.setterGetterQuestionsList=setterGetterQuestionsList;


    }


    @Override
    public int getCount() {
        return setterGetterQuestionsList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View view=null;

        if(convertView==null){


            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.single_question_ui,parent,false);

        }else{

            view=convertView;

        }



        TextView tvQuestion = (TextView) view.findViewById(R.id.tv_question);
         tvQuestion.setText(setterGetterQuestionsList.get(position).getQuestion());





        user=(TextView) view.findViewById(R.id.display_user);
        time=(TextView)view.findViewById(R.id.display_time);
        count=(TextView)view.findViewById(R.id.display_count);
        image=(CircularImageView)view.findViewById(R.id.user_img);

        questionsUser= setterGetterQuestionsList.get(position).getUser();
        questionTime=setterGetterQuestionsList.get(position).getTime();
        questionCount=setterGetterQuestionsList.get(position).answerCount()+" Answer";
        questionUserImage=setterGetterQuestionsList.get(position).getImageUrl();

        user.setText(questionsUser);
        count.setText(questionCount);
        time.setText(questionTime);

        Picasso.with(context).load(questionUserImage).placeholder(R.drawable.user).error(R.drawable.user).into(image);


        return view;
    }


}
