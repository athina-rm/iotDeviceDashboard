#include <ArduinoJson.h>          //for json data deserialization (version 6)

#include <HTTPClient.h>      //for HTTP communication in Esp32

#include <DHT.h>

#include<WiFi.h>                  //for WiFi in Esp32

#define DEVICE_ID "esp32"
#define DHT_PIN 4
#define DHT_TYPE DHT11

const char* ssid="";  //wifi network's ssid
const char* password =""; //wifi network's password
const char* serverName = "http://127.0.0.1:8080/deviceData/add";    //posting URL
static DHT dht(DHT_PIN,DHT_TYPE); //creating an instance dht of DHT

float prevTemp=0;
long prevTime=millis();
time_t epochTime;

void setup() {
  Serial.begin(115200);                 //Serial communication initialization - only for debugging
  initWiFi();                           //initializing Wifi  
  dht.begin();                          //initializing dht sensor module  
  initEpochTime();
}

void loop() {    
  float temperature=dht.readTemperature();      //taking temperature data
  float humidity= dht.readHumidity();           //taking humidity data
  epochTime = time(NULL);
  if ((millis() - prevTime) > 10000)
  {
    char msg[256]; 
    StaticJsonDocument<256> jdoc;                  //declaring jsondocument variable      
    jdoc["deviceId"] = DEVICE_ID;    
    jdoc["temp"] = temperature;            //creating json document with the temperature and humidity data
    jdoc["humidity"] = humidity;
    jdoc["time"] = epochTime;
    serializeJson(jdoc, msg);
    if(WiFi.status()== WL_CONNECTED){
      HTTPClient http;
      http.begin(serverName);
      //http.addHeader("Content-Type", "application/json");
      int httpResponseCode = http.POST(msg);     
     
      Serial.println(msg);                          //for debugging only
      Serial.println(http.getString());
      Serial.println(httpResponseCode);    
      prevTime=millis();
    }
  }
} 
