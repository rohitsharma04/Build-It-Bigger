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

package com.bitshifters.rohit.jokes;

import java.util.Random;

public class JokesTeller {
    public static String getRandomJoke(){
        String[] jokes = {"There are 10 types of people in the world: those who understand binary, and those who don't.",
                "How many programmers does it take to change a light bulb? \n" +
                        "None. It's a hardware problem",
                "A SEO couple had twins. For the first time they were happy with duplicate content.",
                "Why is it that programmers always confuse Halloween with Christmas? \n" +
                        "Because 31 OCT = 25 DEC",
                "Why do they call it hyper text? \n" +
                        "Too much JAVA.",
                "Why was the JavaScript developer sad? \n" +
                        "Because he didn't Node how to Express himself",
                "In order to understand recursion you must first understand recursion.",
                "Why do Java developers wear glasses? Because they can't C#",
                "What do you call 8 hobbits? \n" +
                        "A hobbyte",
                "Why did the developer go broke? \n" +
                        "Because he used up all his cache",
                "Why did the geek add body { padding-top: 1000px; } to his Facebook profile? \n" +
                        "He wanted to keep a low profile.",
                "An SEO expert walks into a bar, bars, pub, tavern, public house, Irish pub, drinks, beer, alcohol",
                "I would tell you a UDP joke, but you might not get it.",
                "8 bytes walk into a bar, the bartenders asks \"What will it be?\"\n" +
                        "One of them says, \"Make us a double.\"",
                "Two bytes meet. The first byte asks, \"Are you ill?\" \n" +
                        "The second byte replies, \"No, just feeling a bit off.\"",
                "If you put a million monkeys on a million keyboards, one of them will eventually write a Java program. " +
                        "The rest of them will write Perl programs.",
                "There's a band called 1023MB. They haven't had any gigs yet.",
                "There are only two hard things in computer science: cache invalidation, naming things, and off-by-one errors."
        };

        //Choosing a random joke id
        Random random = new Random();
        int randomJokeId = random.nextInt(jokes.length);

        return jokes[randomJokeId];
    }
}
