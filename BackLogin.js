import http from 'k6/http';
import {check} from 'k6';

export default function () {
  const domainName = 'https://appapi.local-my.hq-test-aws.qmdev.xyz/';

  const login_endPoint='Account/Login';
  const Toup_endPoint='TopUp/TopUp';

  const login_url=domainName.concat(login_endPoint);
  console.log(login_url);
  const topUp_URL=domainName.concat(Toup_endPoint);

  const login_payload = JSON.stringify({"password": 
"K9jJaJFRS3CqZPxZQmBhTd55WYV7oXBKlmHtG/PpDpmkymhYDJkcZa6Lwl/XVO9MQHJIcW9qRnCQW3895M0A7ARon+rdIFNss1jbF7xZV2FUUdypmXnUbno1v4nHCxv7m9tHiXj/rrw7sxy9d00wfeSBmZ4JqAHs1tFjHkjGp1ok1/PM8lPkoJU0HQbeIBIbyqqvxrWiqXJPLQWnCOfgiwXwSWJtztwwkYzLASZagQPWt9RJaw9rpJZQioixH+XAI7bkSEIbeFZhBatQwbO7gZS2vEMFkL2FjhxdnAz0xyrE1iHsis7VEGtZCOwB3c8C9CftCtT4SvrnbAVh0oLSfA==",
"sourceLoginApp": "web:web",
"username": 
"frHkled4i2PajR/YZqYpUCTb1ylmN6mSCd+FbjRAzjfqiJws1XrnmKn/GBasCzXMi04CSl0mEJWahDKnL4kRTdPjgSLDqPQyfUg90CGZbgq76CgAOKCmN6WZSh8bmY8VUfy0sNehV3Sz5/vajS721ZdtgkjZeU4SzO02ER1hVMp4zQIf5n9fi3oiRMo3zKoFwhKMqPEkONX2LPpPBCgZqY+gxU5B8FGXr3DSOyxfp8pYO2782Cm6jVCwtgjohnL+j11wYLvjg63zLgqmU9i7Ni/a8EmnLrw3CUWOrLrycsCT/egpRBbPu29tdx89NE3fWtWuQ80+avKPFDQ4BvhA2A=="});
  
  const login_params = {
    headers: {
    authority: "appapi.local-my.hq-test-aws.qmdev.xyz",
          accept: "application/json, text/plain, */*",
          "accept-language": "en",
          "content-type": "application/json;charset=UTF-8",
          origin: "https://web.local-my.hq-test-aws.qmdev.xyz",
          referer: "https://web.local-my.hq-test-aws.qmdev.xyz/",
          "sec-ch-ua":
            '"Google Chrome";v="113", "Chromium";v="113", "Not-A.Brand";v="24"',
          "sec-ch-ua-mobile": "?0",
          "sec-ch-ua-platform": '"Windows"',
          "sec-fetch-dest": "empty",
          "sec-fetch-mode": "cors",
          "sec-fetch-site": "same-site",
          "user-agent":
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36"
    },
  };

  const TopupParams = JSON.stringify(
{"goldAccountId":"9495fc9d-3feb-416e-9f7e-e84b79cfcb2d","topUpAmount":"123.00","isConvertToGCA":true,"bankAccountId":"8157b205-3f0c-42de-bf20-9d94313ac906","paymentMethod":0,"paymentAccountId":null
      });

  const res = http.post(login_url, login_payload, login_params);
  
  console.log(res);

  //   var obj = JSON.parse(res);

     var Access_Token = res.json().data.accessToken;
     console.log(Access_Token);

  
  check(res, {
    'status is 200': (r) => r.status == 200,
      'Code is 0': (r) => r.json().code == 0,
    'message is ok': (r) => r.json().message == 'ok',
    'Name validation':        (r) => r.json().data.customerInfo.fullName == 'Manikandan',
     'Customer ID is exist':        (r) => r.json().data.customerInfo.id == '2e3ea10e-0a95-47d8-934d-f0af9d18bd82',
    'Access token param should exist': (r) =>
      r.body.includes('accessToken'),
     'Access token should be non-empty': (r) => r.json().data.accessToken.length > 0,
      'accessTokenExpireTime param should exist': (r) =>
      r.body.includes('accessTokenExpireTime'),
     'accessTokenExpireTime should be non-empty': (r) => r.json().data.accessTokenExpireTime == 86400,
  });
  

  const payload_accessToken = JSON.stringify({ "authority": "appapi.local-my.hq-test-aws.qmdev.xyz",
    "accept": "application/json, text/plain, */*",
    "accept-language": "en",
    "authorization":Access_Token,
    "content-type": "application/json;charset=UTF-8",
    "origin": "https://web.local-my.hq-test-aws.qmdev.xyz",
    "referer": "https://web.local-my.hq-test-aws.qmdev.xyz/",
    "sec-ch-ua": "\"Google Chrome\";v=\"113\", \"Chromium\";v=\"113\", \"Not-A.Brand\";v=\"24\"",
    "sec-ch-ua-mobile": "?0",
    "sec-ch-ua-platform": "\"Windows\"",
    "sec-fetch-dest": "empty",
    "sec-fetch-mode": "cors",
    "sec-fetch-site": "same-site",
    "user-agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36"
  });



  const Topup_url=domainName.concat(Toup_endPoint);

    const TopupResponse = http.post(Topup_url, payload_accessToken, TopupParams);
  
  console.log(TopupResponse);

   check(TopupResponse, {
    'Topup status code is 200': (r) => r.status == 200,
      'Code is 1': (r) => r.json().code == 1,
    
  });


}
 