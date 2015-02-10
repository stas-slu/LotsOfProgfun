function addRow(tableID) {
    var table = document.getElementById(tableID);

    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);

    var cell1 = row.insertCell(0);
    var element1 = document.createElement("input");
    element1.type = "checkbox";
    element1.name="chkbox[]";
    cell1.appendChild(element1);

    var cell2 = row.insertCell(1);
    cell2.innerHTML = rowCount + 1;

    var cell3 = row.insertCell(2);
    var element2 = document.createElement("input");
    element2.type = "text";
    element2.name = "txtbox[]";
    cell3.appendChild(element2);
}

function addRowNew(tableID) {
    var table = document.getElementById(tableID);
    var name = document.getElementById('name').value;
    var lastname = document.getElementById('lastname').value;
    var department = document.getElementById('department').value;
    var age = document.getElementById('age').value;
    var gender = getGenderFromDom();

    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);

    var cell1 = row.insertCell(0);
    var element1 = document.createElement("input");
    element1.type = "checkbox";
    element1.name="chkboxWorker";
    cell1.appendChild(element1);

    var cell2 = row.insertCell(1);
    var element2 = document.createTextNode(name);
    cell2.appendChild(element2);

    var cell3 = row.insertCell(2);
    var element3 = document.createTextNode(lastname);
    cell3.appendChild(element3);

    var cell4 = row.insertCell(3);
    var element4 = document.createTextNode(department);
    cell4.appendChild(element4);

    var cell5 = row.insertCell(4);
    var element5 = document.createTextNode(age);
    cell5.appendChild(element5);

    var cell6 = row.insertCell(5);
    var element6 = document.createTextNode(gender);
    cell6.appendChild(element6);
}

function getGenderFromDom() {
    var genders = document.getElementsByName('gender');
    var gender;
    var gendersLength = genders.length;
    while (gendersLength--) {
        if (genders[gendersLength].checked)
            gender = genders[gendersLength].value;

    }
    return gender;
}

function deleteRows(tableID) {
    try {
        var table = document.getElementById(tableID);
        var rowCount = table.rows.length;

        for(var i=0; i<rowCount; i++) {
            var row = table.rows[i];
            var chkbox = row.cells[0].childNodes[0];
            if(null != chkbox && true == chkbox.checked) {
                table.deleteRow(i);
                rowCount--;
                i--;
            }
        }
    }catch(e) {
        alert(e);
    }
}

function checkAll(tableID) {
    try {
        var table = document.getElementById(tableID);
        var rowCount = table.rows.length;

        for(var i=0; i<rowCount; i++) {
            var row = table.rows[i];
            var chkbox = row.cells[0].childNodes[0];
            if(null != chkbox && false == chkbox.checked) {
                chkbox.checked = true;
            }
        }
    }catch(e) {
        alert(e);
    }
}