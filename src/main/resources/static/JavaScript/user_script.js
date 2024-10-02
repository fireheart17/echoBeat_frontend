document.addEventListener('DOMContentLoaded', () => {
    const changeInfoBtn = document.getElementById('change-info-btn');
    const userInfoForm = document.getElementById('user-info-form');
    const closeFormBtn = document.getElementById('close-form');

    // When "Change User Information" button is clicked, show the form
    changeInfoBtn.addEventListener('click', () => {
        userInfoForm.style.display = 'flex';
    });

    // Close the form when the "Close" button is clicked
    closeFormBtn.addEventListener('click', () => {
        userInfoForm.style.display = 'none';
    });
});