void initEpochTime() {
  configTime(3600, 0, "pool.ntp.org", "time.nist.gov");

  while(true) {
    epochTime = time(NULL);

    if(epochTime == 28800) {
      delay(2000);
    } else {
      break;
    }
  }

  Serial.printf("Epochtime initialized. Current Time: %lu", epochTime);
}
