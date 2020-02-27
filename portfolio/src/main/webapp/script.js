// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addMovieQuote() {
  const quotes =
      ['\"With great power comes great responsibility\" \n- Voltaire' +
            '\n(but also Uncle Ben)',
       '\"You\'re killin\' me, Smalls!\"\n- Ham Porter',
       '\"Why do we fall, Bruce? So we can learn to pick ourselves up.' +
            '\"\n- Thomas Wayne',
       '\"At some point, everything is going to go south on you. You ' +
            'can either accept that, or you can get to work.\"\n- Mark Watney',
       '\"I have been and always shall be your friend.\"\n- Spock',
       '\"I don\'t scratch my head unless it itches and I don\'t dance' +
            ' unless I hear some music. I will not be intimidated. ' +
            'That\'s just the way it is.\"\n- Herman Boone',
       '\"Sometimes you gotta run before you can walk.\"\n- Tony Stark',
       '\"You never know what events are to transpire to get you home.' +
            '\"\n- Jim Lovell',
       '\"It\'s not about deserve, it\'s about what you believe. And ' +
            'I believe in love.\"\n- Diana Prince'];

  // Pick a random greeting.
  const quote = quotes[Math.floor(Math.random() * quotes.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = quote;
}

function getJSONString() {
    fetch('/data').then(response => response.json()).then((response) => {
        const JSONElementList = document.getElementById('JSON-container')
        JSONElementList.innerText = response;
        console.log(response);
    });
}
