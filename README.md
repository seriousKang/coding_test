## coding test
### 용어
#### 나눗셈
- quotient: 몫
- remainder: 나머지
- dividend: 피제수
- divisor: 제수

---

### 유용한 기능
#### array
- 배열 복사: `System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)`
- 스트림: `Arrays.stream(T[] array)` *<span style="color:grey">-> `java.util` 패키지</span>*

#### collections
- swap: `Collections.swap(List<?> list, int i, int j)` *<span style="color:grey">-> `java.util` 패키지</span>*
- `map`
  - `containsKey`, `containsValue`

#### stream
- IntStream *<span style="color:grey">-> `java.util.stream` 패키지</span>*
  - 생성: `IntStream.range(int startInclusive, int endExclusive)` 

#### 진법 변환
- n진수 -> 10진수: `Integer.parseInt(String s, int radix)`
  > ex. Integer.parseInt("21", 3) -> 7