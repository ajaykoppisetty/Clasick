package ParseWorks;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.tech.club.MainActivity;
import com.tech.club.Profile;
import com.tech.club.QuesSending;

import java.net.URL;

/**
 * Created by Home on 05-07-2015.
 */
public class DisplayImage {


    public static void retreiveprofile(String username , final Context context) {
        ParseQuery<ParseObject> query= ParseQuery.getQuery("Profile");
        query.whereEqualTo("user",username);
        query.getFirstInBackground(new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject parseObject, ParseException e) {

                if(parseObject!=null && e==null) {

                    ParseFile file = (ParseFile) parseObject.get("image");
                    String url = "http://wwww.webianks.com";

                    if (file != null) {
                        url = file.getUrl().toString();
                    }

                    MainActivity.retriveProfileCallback(context, url);

                }else{
                    //canntretrivee file
                }
            }
        });

    }

    public static void retreivetimelineprofile(String username , final Context context) {
        ParseQuery<ParseObject> query= ParseQuery.getQuery("Profile");
        query.whereEqualTo("user",username);
        query.getFirstInBackground(new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject parseObject, ParseException e) {

                if(parseObject!=null && e==null) {

                    ParseFile file = (ParseFile) parseObject.get("image");
                    String url = "http://wwww.webianks.com";
                    if (file != null) {

                        url = file.getUrl().toString();
                    }

                    Profile.retriveTimelineProfileCallback(context, url);

                }else{
                    //canntretrivee file
                }
            }
        });

    }

   /* public static void retreiveUrl(String username, final Context context) {
        ParseQuery<ParseObject> query= ParseQuery.getQuery("Profile");
        query.whereEqualTo("user",username);
        query.getFirstInBackground(new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject parseObject, ParseException e) {

                if(parseObject!=null && e==null) {

                    ParseFile file = (ParseFile) parseObject.get("image");
                    String url = "http://wwww.webianks.com";
                    if (file != null) {
                        url = file.getUrl().toString();
                    }

                    QuesSending.retriveUrlCallback(context, url);

                }else{
                    //canntretrivee file
                }
            }
        });

    }*/
}
