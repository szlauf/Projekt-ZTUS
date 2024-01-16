document.addEventListener("DOMContentLoaded", function () {
  const toggleModeButton = document.getElementById("toggleModeButton");
  const mainStylesheet = document.getElementById("stylesheet");
  const darkModeStylesheet = document.getElementById("darkModeStylesheet");

  // Funkcja do ustawiania trybu ciemnego
  function enableDarkMode() {
    mainStylesheet.setAttribute("disabled", "true");
    darkModeStylesheet.removeAttribute("disabled");
    localStorage.setItem("darkMode", "enabled");
  }

  // Funkcja do ustawiania trybu jasnego
  function disableDarkMode() {
    darkModeStylesheet.setAttribute("disabled", "true");
    mainStylesheet.removeAttribute("disabled");
    localStorage.setItem("darkMode", "disabled");
  }

  // Toggle dark mode na kliknięcie przycisku
  if (toggleModeButton && mainStylesheet && darkModeStylesheet) {
    toggleModeButton.addEventListener("click", function () {
      var currentMode = localStorage.getItem("darkMode");
      if (currentMode === "enabled") {
        disableDarkMode();
      } else {
        enableDarkMode();
      }
    });
  } else {
    console.error("Nie udało się znaleźć elementów DOM.");
  }

  // Sprawdź preferencję trybu ciemnego przy ładowaniu strony
  var storedMode = localStorage.getItem("darkMode");
  if (storedMode === "enabled") {
    enableDarkMode();
  } else {
    disableDarkMode();
  }
});
