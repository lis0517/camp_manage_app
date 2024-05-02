## 내배캠 캠프 관리 프로그램

내배캠 스프링 수강생들을 관리하는 프로그램입니다.

#### 요구 사항 정의

<details>
<summary>캠프에는 필수 과목과 선택 과목이 존재합니다.</summary>
<div markdown="1">
<table style="border-collapse: collapse; border: none;">
<tr><td style="border: none; vertical-align: top;">

|필수 과목 목록|
|-------------|
|Java|
|객체지향|
|Spring|
|JPA|
|MySQL|

</td>
<td style="border: none; vertical-align: top;">

|선택 과목 목록|
|-------------|
|디자인 패턴|
|Spring Security|
|Spring|
|Redis|
|MongoDB|

</td>
</tr>
</table>
</div>


<details>
<summary>조건</summary>
<div markdown="1">

- 최소 3개 이상의 필수 과목, 2개 이상의 선택 과목을 선택합니다.
- 캠프 기간동안 선택한 과목별로 총 10회의 시험을 봅니다.
- 캠프 매니저는 수강생을 등록 및 관리할 수 있습니다.
- 캠프 매니저는 수강생들의 과목과 시험 점수를 등록 및 관리할 수 있습니다.
- 점수 데이터 타입 : 정수형
- 점수에 따라 등급이 매겨집니다.
  - 과목 : Java
    |1회차|2회차|3회차|...|
    |----|----|----|----|
    |D|D|B|...|

- 등급 산정 기준
  - 필수 과목
    |A|B|C|D|F|N|
    |----|----|----|----|----|----|
    |95 ~ 100|90 ~ 94|80 ~ 89|70 ~ 79|60 ~ 69|60점 미만|

  - 선택 과목
    |A|B|C|D|F|N|
    |----|----|----|----|----|----|
    |90 ~ 100|80 ~ 89|70 ~ 79|60 ~ 69|50 ~ 59|50점 미만|

</div>
</details>

</details>

#### 기능 명세서


<details>
<summary>필수 요구 사항</summary>
<div markdown="1">
<table style="border-collapse: collapse; border: none;">
<tr>
<td style="border: none; vertical-align: top;">
<details>
<summary>수강생 관리</summary>
<div markdown="1">

- 주의 ‼️
  - 수강생의 고유번호는 중복될 수 없습니다.
  
1. 수강생 정보를 등록할 수 있습니다.
   |등록 필수 정보|
   |-------------|
   |고유 번호|
   |이름|
   |과목 목록|


1. 수강생 목록을 조회할 수 있습니다. 조회 형식은 자유입니다.
   |조회 필수 정보|
   |-------------|
   |고유 번호|
   |이름|

</div>
</details>


<details>
<summary>점수 관리</summary>
<div markdown="1">

- 주의 ‼️
  - 등록하려는 과목의 회차 점수가 이미 등록되어 있다면 등록할 수 없습니다. 과목의 회차 점수가 중복되어 등록될 수 없습니다.
  - 회차에 10 초과 및 1 미만의 수가 저장될 수 없습니다. (회차 범위: 1 ~ 10)
  - 점수에 100 초과 및 음수가 저장될 수 없습니다. (점수 범위: 0 ~ 100)
  
1. 수강생의 과목별 시험 회차 및 점수를 등록할 수 있습니다.
   - 점수를 등록하면 자동으로 등급이 추가 저장됩니다.
  
2. 수강생의 과목별 회차 점수를 수정할 수 있습니다.

3. 수강생의 특정 과목 회차별 등급을 조회할 수 있습니다.
   - 조회 형식은 자유입니다.
     |조회 필수 정보|
     |-------------|
     |고유 번호|
     |이름|

</div>
</details>

</div>
</details>
</div>
</details>
</td>
</tr>
</table>
</div>
</details>
