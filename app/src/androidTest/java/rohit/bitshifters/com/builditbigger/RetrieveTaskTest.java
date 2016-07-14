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

package rohit.bitshifters.com.builditbigger;

import android.test.AndroidTestCase;

/**
 * Created by rohit on 7/14/16.
 */
public class RetrieveTaskTest extends AndroidTestCase{

    //Retrieve Joke AsyncTask Test.
    public void testRetrieveJoke(){
        new RetrieveJokeTask(new RetrieveJokeTask.Listener() {
            @Override
            public void onJokeLoaded(String joke) {
                assertNotNull(joke);
                assertNotSame(joke,"");
            }
        }).execute();
    }

}
