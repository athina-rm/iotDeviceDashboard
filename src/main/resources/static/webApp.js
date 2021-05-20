let sensorData = document.getElementById('{replace by table id from html}')

fetch("{replace by azure database url}")
    .then(res => res.json())
    .then(data => {
        for(let row of data) {
            sensorData.innerHTML += `<tr><td>${row.id}</td><td>${row.deviceId}</td><td>${row.time}</td><td>${row.temp}</td><td>${row.data.humidity}</td>`

        }
    })