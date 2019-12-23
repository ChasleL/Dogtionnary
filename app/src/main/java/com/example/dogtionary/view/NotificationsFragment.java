package com.example.dogtionary.view;

import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.example.dogtionary.R;

import static android.content.Context.NOTIFICATION_SERVICE;

public class NotificationsFragment extends Fragment {

    private Button.OnClickListener mOnDisplayNotificationButtonClick = new Button.OnClickListener() {

        @Override
        public void onClick(View view) {
            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(getContext())
                            //.setSmallIcon(R.drawable.ic_notifications_black_24dp)
                            .setContentTitle("BottomNavigationView")
                            .setContentText("Example Notification");
            NotificationManager mNotifyMgr =
                    (NotificationManager) getActivity().getSystemService(NOTIFICATION_SERVICE);
            mNotifyMgr.notify(1, builder.build());

        }
    };

    public NotificationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        Button displayNotificationButton = (Button) view.findViewById(R.id.display_notification);
        displayNotificationButton.setOnClickListener(mOnDisplayNotificationButtonClick);
        return view;
    }

}