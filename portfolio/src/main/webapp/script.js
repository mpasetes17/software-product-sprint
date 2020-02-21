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
function addRandomGreeting() {
  const greetings =
      ['\"With great power comes great responsibility\" \n- Voltaire\n(but also Uncle Ben)',
       '\"You\'re killin\' me, Smalls!\"\n- Ham Porter',
       '\"Why do we fall, Bruce? So we can learn to pick ourselves up.\"\n- Thomas Wayne',
       '\"At some point, everything is going to go south on you. You can either accept that, or you can get to work.\"\n- Mark Watney'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}
