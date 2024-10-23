// This script fetches the songId from the URL and updates the page with the corresponding song.
const urlParams = new URLSearchParams(window.location.search);
const songId = urlParams.get('songId');

// Update the song title and load corresponding audio (this can be dynamic if you have a back-end)
document.getElementById('songTitle').innerText = `Playing: Song Title ${songId}`;