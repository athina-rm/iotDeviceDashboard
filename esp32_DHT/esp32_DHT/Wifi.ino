void initWiFi(){
  WiFi.begin(ssid,password);                //starting Wifi connection
  while (WiFi.status() != WL_CONNECTED) {   //printing '.' until the Wifi is connected
      delay(500);
      Serial.print(".");
    }
    Serial.println("");
    Serial.println("WiFi connected.");
    Serial.print("IP address: ");
    Serial.println(WiFi.localIP());         //printing IP address of the connected esp device 
  }
