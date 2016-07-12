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

package com.bitshifters.rohit.jokeviewerlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class JokeViewer extends AppCompatActivity {

    public static final String JOKE_EXTRA = "joke_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_viewer);

        TextView tvJoke = (TextView) findViewById(R.id.tvJoke);

        if(getIntent() != null && getIntent().hasExtra(JOKE_EXTRA)){
            String joke = getIntent().getStringExtra(JOKE_EXTRA);
            if(joke != null || !joke.equals("")) {
                tvJoke.setText(joke);
            }
            else{
                tvJoke.setText(getString(R.string.no_jokes_string));
            }
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
