document.addEventListener("DOMContentLoaded", function () {
  // Wypełnij listę marek samochodów
  var brandSelect = document.getElementById("brand");
  var brands = ["Volvo", "BMW", "Mercedes", "Ford"];
  fillDropdown(brandSelect, brands);

  // Wypełnij listę lat produkcji samochodów
  var yearSelect = document.getElementById("year");
  var years = ["2022", "2021", "2020"];
  fillDropdown(yearSelect, years);

  // Nasłuchuj zmian w polu marki
  brandSelect.addEventListener("change", function () {
    // Pobierz wybraną markę
    var selectedBrand = brandSelect.value;

    // Pobierz listę modeli dla danej marki
    var modelsForBrand = getModelsForBrand(selectedBrand);

    // Wypełnij listę modeli samochodów
    var modelSelect = document.getElementById("model");
    modelSelect.innerHTML = ""; // Wyczyść istniejące elementy

    fillDropdown(modelSelect, modelsForBrand);
  });
});

function fillDropdown(selectElement, options) {
  for (var i = 0; i < options.length; i++) {
    var option = document.createElement("option");
    option.value = options[i];
    option.text = options[i];
    selectElement.add(option);
  }
}

function getModelsForBrand(brand) {
  // Tutaj możesz zaimplementować logikę pobierania modeli
  // dla danej marki. Poniżej przykładowa implementacja.

  switch (brand) {
    case "Volvo":
      return ["XC90", "S60", "Polestar"];
    case "BMW":
      return ["Seria 3", "Seria 5", "Seria 7"];
    case "Mercedes":
      return ["C klasa ", "A klasa", "S klasa"];
    case "Ford":
      return ["Fiesta", "Kuga", "Transit"];
    default:
      return [];
  }
}

function searchCars() {
  // Tutaj możesz dodać kod obsługujący wyszukiwanie samochodów
  // na podstawie wybranych opcji marek, modeli i lat produkcji.
  // Na razie funkcja jest pusta.
  console.log("Wyszukiwanie samochodów...");
}
