function playTrack(trackId) {
    fetch(`/play?trackId=${trackId}`, {
        method: 'GET',
        headers: {
            'Authorization': `Bearer dsnfnbfdbnfdb.fbfjdbgfbllb.fdgijfdlbfdlb}` // Adjust token retrieval as needed
        }
    })
    .then(response => {
        if (response.ok) {
            alert('Playing track!');
        } else {
            alert('Failed to play track.');
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });
}
