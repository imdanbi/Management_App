package com.example.sd;

import androidx.annotation.Nullable;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class CourseAddRequest extends StringRequest {
    final static private String URL = "http://mymg.dothome.co.kr/UserSchedule.php";
    private Map<String, String> parameters;

        public CourseAddRequest(String userID, String courseTitle, String courseProfessor, String courseRoom,String day, String startTime,String endTime,Response.Listener<String> listener){
            super(Method.POST, URL, listener, null);
            parameters = new HashMap<>();
            parameters.put("userID", userID);
            parameters.put("courseTitle", courseTitle);
            parameters.put("courseProfessor", courseProfessor);
            parameters.put("courseRoom", courseRoom);
            parameters.put("day", day);
            parameters.put("startTime", startTime);
            parameters.put("endTime", endTime);

        }

        @Override
        public Map<String, String> getParams() {
            return parameters;
        }
}
