 
#include <SoftwareSerial.h>
#ifndef HAVE_HWSERIAL1
#include "WiFiEsp.h"

int sensor_01;
int sensor_02;
int sensor_03;
SoftwareSerial mySerial(6,7); //RX,TX 
#endif

String ssid = "AXLER-AP"; 
String PASSWORD = "322412"; 
String host = "192.168.0.100"; 


// 사물감지 센서 핀값입니다
int infrared  = 3;
int led = 10;
int infrared2  = 4;
int led2 = 11;
int infrared3  = 8;
int led3 = 12;
// 여기까지


void connectWifi(){
  
  String join ="AT+CWJAP=\""+ssid+"\",\""+PASSWORD+"\"";
  Serial.println("Connect Wifi..."); 
  mySerial.println(join); 
  delay(20000);
  if(mySerial.find("OK")) 
  {
    Serial.print("WIFI connect\n");
    }else
    { 
      Serial.println("connect \n");
    }
    delay(1000);
    }
    
    void httpclient(String char_input){
      delay(100); 
      Serial.println("connect TCP...");
      mySerial.println("AT+CIPSTART=\"TCP\",\""+host+"\",80"); 
      delay(500); 
      if(Serial.find("ERROR")) return;
      
      Serial.println("Send data...");
      String url=char_input; 
      String cmd="GET /process.php?sensor_01="+url+" HTTP/1.0\r\n\r\n";
      mySerial.print("AT+CIPSEND=");
      mySerial.println(cmd.length()); 
      Serial.print("AT+CIPSEND=");
      Serial.println(cmd.length()); 
      if(mySerial.find(">"))
      {
        Serial.print(">");
        }else
        {
          mySerial.println("AT+CIPCLOSE"); 
          Serial.println("connect timeout"); 
          delay(1000); return;
          }
          delay(500);
          mySerial.println(cmd); 
          Serial.println(cmd); 
          delay(100); 
          if(Serial.find("ERROR")) return;
          mySerial.println("AT+CIPCLOSE"); 
          delay(100);
          } 
          
          void setup() 
          { 
            Serial.begin(9600); 
            mySerial.begin(9600);
            connectWifi(); delay(500); 
            }
            
            void loop() 
            {
              // 적외선 감지 센서 부터 센서값을 읽습니다.
               // 감지되면 0, 감지되지 않으면 1이 나옵니다.
              int state = digitalRead(infrared);
              int state2 = digitalRead(infrared2);
              int state3 = digitalRead(infrared3);

               // 측정된 센서값이 0(감지)면 아래 블록을 실행합니다.
  // 1번센서
  if(state == 0){
    // LED를 켜지도록 합니다.
    digitalWrite(led, HIGH);
    // 경보 메세지를 시리얼 모니터에 출력합니다.
    Serial.println("1_sensor ON");
    sensor_01 = 10;
  }
  /// 측정된 센서값이 0 이외(감지되지 않음) 이면 아래 블록을 실행합니다.
  else{
    // LED를 꺼지도록 합니다.
    digitalWrite(led, LOW);
    // 안전 메세지를 시리얼 모니터에 출력합니다.
    Serial.println("1_sensor OFF");
    sensor_01 = 11;
    
  }

   // 2번센서
  if(state2 == 0){
    // LED를 켜지도록 합니다.
    digitalWrite(led2, HIGH);
    // 경보 메세지를 시리얼 모니터에 출력합니다.
    Serial.println("2_sensor ON");
    sensor_02 = 20;
  }
  /// 측정된 센서값이 0 이외(감지되지 않음) 이면 아래 블록을 실행합니다.
  else{
    // LED를 꺼지도록 합니다.
    digitalWrite(led2, LOW);
    // 안전 메세지를 시리얼 모니터에 출력합니다.
    Serial.println("2_sensor OFF");
    sensor_02 = 22;
    
  }

   // 3번센서
  if(state3 == 0){
    // LED를 켜지도록 합니다.
    digitalWrite(led3, HIGH);
    // 경보 메세지를 시리얼 모니터에 출력합니다.
    Serial.println("3_sensor ON");
    sensor_03 = 30;
  }
  /// 측정된 센서값이 0 이외(감지되지 않음) 이면 아래 블록을 실행합니다.
  else{
    // LED를 꺼지도록 합니다.
    digitalWrite(led3, LOW);
    // 안전 메세지를 시리얼 모니터에 출력합니다.
    Serial.println("3_sensor OFF");
    sensor_03 = 33;
    
  }
            
              
           
              String str_output = String(sensor_01)+"&sensor_02="+String(sensor_02)+"&sensor_03="+String(sensor_03); 
              delay(1000);
              httpclient(str_output);
              delay(1000);
              
              //Serial.find("+IPD");
              while (mySerial.available())
              { 
                char response = mySerial.read();
                Serial.write(response); 
                if(response=='\r') Serial.print('\n');
                }
                Serial.println("\n==================================\n"); 
                delay(2000);
                }
