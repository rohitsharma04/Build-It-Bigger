/*
 * Copyright 2016 Rohit Sharma (skyrohithigh)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Created by rohit on 7/17/16.
 */
package rohit.bitshifters.com.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.bitshifters.rohit.jokeviewerlibrary.JokeViewer;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import rohit.bitshifters.com.builditbigger.R;
import rohit.bitshifters.com.builditbigger.RetrieveJokeTask;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private final String TAG = MainActivityFragment.class.getSimpleName();
    private Context mContext;
    private InterstitialAd mInterstitialAd;
    private ProgressBar mProgressBar;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Setting up InterstitialAd
        mInterstitialAd = new InterstitialAd(getContext());
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_test_ad_id));
        requestNewInterstitial();

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                Log.v(TAG,"Closing InterstitialAd");
                requestNewInterstitial();
                fetchJoke();
            }
        });


        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mProgressBar = (ProgressBar) root.findViewById(R.id.joke_loading_spinner);

        //Small Ad at the bottom
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        mContext = root.getContext();

        //Setting up button
        Button button = (Button)  root.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    Log.v(TAG,"Showing InterstitialAd");
                    mInterstitialAd.show();
                } else {
                    Log.v(TAG,"InterstitialAd loading not finished");
                    fetchJoke();
                }
            }
        });


        return root;
    }

    private void fetchJoke() {
        Log.v(TAG,"Fetching Joke");
        mProgressBar.setVisibility(View.VISIBLE);
        new RetrieveJokeTask(new RetrieveJokeTask.Listener() {
            @Override
            public void onJokeLoaded(String joke) {
                mProgressBar.setVisibility(View.GONE);
                Intent intent = new Intent(mContext, JokeViewer.class);
                intent.putExtra(JokeViewer.JOKE_EXTRA, joke);
                startActivity(intent);
            }
        }).execute();
    }

    private void requestNewInterstitial() {
        Log.v(TAG,"Requesting new InterstitialAd");
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);
    }
}
