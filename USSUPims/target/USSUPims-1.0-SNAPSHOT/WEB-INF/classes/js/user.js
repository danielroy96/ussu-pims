var xmlHttpRequest = new XMLHttpRequest();

function searchUsers() {
    var forename = document.getElementById('forename').value;
    var surname = document.getElementById('surname').value;
    xmlHttpRequest.open('GET', "user/search/f=" + forename + "/s=" + surname, true);
    xmlHttpRequest.send();
    xmlHttpRequest.onreadystatechange = processSearchUsersResults;
}

function processSearchUsersResults() {
    var container = document.getElementById('search-result-tbody')
    if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
        results = JSON.parse(xmlHttpRequest.response);
        $("#search-result-container").hide();
        while (container.firstChild) {
            container.removeChild(container.firstChild);
        }
        results.forEach(function (result) {
            $("#search-result-container").show();
            appendSearchResult(result.username, result.title, result.forename, result.surname, result.id);
        });
    }
    if ($("#search-result-tbody").children().length === 0) {
        $("#no-results-alert").show();
    } else {
        $("#no-results-alert").hide();
    }
    
}

function appendSearchResult(username, title, forename, surname, id) {
    var container = document.getElementById('search-result-tbody');
    var resultContainer = document.createElement('tr');
    var usernameContainer = document.createElement('td');
    var fullNameContainer = document.createElement('td');
    var modifyUserContainer = document.createElement('td');
    //var button = document.createElement('button');
    //button.appendChild(document.createTextNode('Modify user'));

    usernameContainer.appendChild(document.createTextNode(username));
    fullNameContainer.appendChild(document.createTextNode(title + ' ' + forename + ' ' + surname));
    //modifyUserContainer.appendChild(button);
    $("<a>", {
        href: "/user/" + id,
        text: "Modify user..."
    }).appendTo(modifyUserContainer);
    resultContainer.appendChild(usernameContainer);
    resultContainer.appendChild(fullNameContainer);
    resultContainer.appendChild(modifyUserContainer);
    container.appendChild(resultContainer);
}