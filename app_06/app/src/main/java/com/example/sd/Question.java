package com.example.sd;

public class Question {


    public static String question[] = {
            "유스케이스의 구성요소 간의 관계에 포함되지 않는 것은?",
            "정보공학 방법론에서 데이터베이스 설계의 표현으로 사용하는 모델링 언어는?",
            "GoF디자인 패턴을 생성,구조,행동 패턴의 세 그룹으로 분류할 때 구조패턴이 아닌 것은?",
            "속성과 관련된 연산을 클래스 안에 묶어서 하나로 취급하는 것을 의미하는 객체지향 개념은?",
            "시스템의 상태와 사용자의 지시에 대한 효과를 보여주어 사용자가 명령에 대한 진행 상황과 표시된 내용을 해석할 수 있도록 도와주는것은?",
            "럼바우의 객체지향 분석기법 중 자료흐름(DFD)을 주로 이용하는 것은?",
            "소프트웨어 설계에서 사용되는 대표적인 추상화 기법이 아닌 것은?",
            "요구사항 정의 및 분석 설계의 결과물을 표현하기 위한 모델링 과정에서 사용되는 다이어그램이 아닌것은?",
            "기본 유스케이스 수행 시 특별한 조건을 만족할 때 수행하는 유스케이스는?",
            "현행 시스템 분석에서 고려하지 않아도 되는 항목은?"
    };

    public static String answers[][] = {
            {"연관", "확장", "구체화", "일반화"},
            {"Package Diagram", "State Transition Diagram", "Deployment Diagram", "Entity-Relationship Diagram"},
            {"Adapter 패턴", "Bridge 패턴", "Builder 패턴", "Proxy 패턴"},
            {"Inheritance", "Class", "Encapsulation", "Association"},
            {"Feedback", "Posture", "Module", "Hash"},
            {"기능 모델링","동적 모델링","객체 모델링","정적 모델링"},
            {"자료 추상화","제어 추상화","과정 추상화","강도 추상화"},
            {"DFD Diagram","UML Diagram","E-R Diagram","AVL Diagram"},
            {"연관","확장","선택","특화"},
            {"DBMS 분석","네트워크 분석", "운영체제 분석","인적 자원분석"}

    };

    public static String correct[] = {
            "구체화",
            "Entity-Relationship Diagram",
            "Builder 패턴",
            "Encapsulation",
            "Feedback",
            "기능 모델링",
            "강도 추상화",
            "AVL Diagram",
            "확장",
            "인적 자원분석"
    };

    public static String question_2[] = {
            "다음 중 블랙박스 테스트 기법이 아닌것은?",
            "다음 산술식을 Postfix Notation으로 변환한 결과는? " +
                    "(B+C) * E - F / G",
            "전체 조건식뿐만 아니라 개별 조건식도 참한번, 거짓 한번 결과가 되도록 수행하는 테스트 커버리지는 무엇인가?",
            "필드 테스팅이라고도 불리며 개발자 없이 고객의 사용환경에 소프트웨어를 설치하여 검사를 수행하는 테스트는?",
            "로컬 저장소와 원격 저장소로 분리된 구조인 분산 저장소 방식에서 사용되는 도구는?",
            "서비스 호출, 컴포넌트 재사용 등 다양한 환경을 지원하는 테스트 프레임 워크의 검증 도구는 무엇인가?",
            "다음 중 8개의 정점으로 구성된 무방향 그래프의 최대 간선 수는?",
            "해싱 함수에서 어떤 진법으로 표현된 주어진 레코드 키를 다른 진법으로 간주하고 키를 변환하여 홈주소를 얻는 방식은?",
            "테스트의 실행결과가 올바른 결과인지 판단하는 매커니즘은?",
            "시스템에 고의로 실패를 유도하는 테스트 기법은?"
    };

    public static String answers_2[][] = {
            {"State Transition Testing", "Classification Tree Method Testing", "Comparison Testing", "Control Flow Testing"},
            {"-B C + E * F G /", "B C + * - F / G", "B C + E - * F G /", "B C + E * F G / -"},
            {"Condition Coverage", "Condition/Decision Coverage", "Modified Condition/Decision Coverage", "Statement Coverage"},
            {"베타 테스트", "알파 테스트", "오라클 테스트", "상태 전이 테스트"},
            {"RCS", "CVS", "Bitkeeper", "SVN"},
            {"xUnit","STAF","FitNesse","NTAF"},
            {"18","22","26","28"},
            {"제산 법(Division)","기수 변환법(Radix Conversion)","제곱법(Mid Square)","폴딩법(Folding)"},
            {"테스트 하네스","테스트 오라클","테스트 종료기준 ","워크스루"},
            {"Security Test","Performance Test","Stress Test","Recovery Test"}
    };

    public static String correct_2[] = {
            "Control Flow Testing",
            "B C + E * F G / -",
            "Condition/Decision Coverage",
            "베타 테스트",
            "Bitkeeper",
            "STAF",
            "28",
            "기수 변환법(Radix Conversion)",
            "테스트 오라클",
            "Recovery Test"
    };


    public static String question_3[] = {
            "한 릴레이션에 같은 키 값을 가진 튜플들을 허용할 수 없다는 제약조건에 대한 데이터 베이스 무결성의 종류는?",
            "데이터 모델 중 트랜잭션의 인터페이스를 설계하는 단계이자 DBMS에 맞는 논리적 스키마를 설계하는 모델은? ",
            "병행 제어기법 중 트랜잭션 종료시 검증을 수행하여 데이터베이스에 반영하는 기법은 무엇인가?",
            "다음 중 제 2정규형에서 제 3정규형이 되기 위한 조건은?",
            "LIKE와 같이 사용하는 와일드 문자 중 0개 이상의 문자열과 일치하는 문자열 검색시 사용하는 와일드 문자는?",
            "먼저 선행 테이블의 처리 범위를 하나씩 액세스하면서 추출된 값으로 연결한 테이블을 조인하는 물리적 조인 방식은?",
            "직렬가능성이 보장되는 적절한 버전을 선택하여 접근하도록 하는 병행 제어 기법은?",
            "튜플에 대한 유일성은 만족하나 최소성을 만족하지 못하는 키는 무엇인가?",
            "E-R 모델에서 다중값 속성의 표기법은?",
            "뷰(View)에 대한 설명으로 틀린 것은?"
    };

    public static String answers_3[][] = {
            {"개체 무결성", "속성 무결성", "사용자 무결성", "키 무결성"},
            {"개념적 데이터 모델", "논리적 데이터 모델", "물리적 데이터 모델", "형식적 데이터 모델"},
            {"Locking", "Optimistic Validation", "Time Stamp Ordering", "Mutli Version Concurrency Control"},
            {"결정자가 후보키가 아닌 함수 종속 제거", "이행적 함수 종속 제거", "부분적 함수 종속 제거", "원자값이 아닌 도메인 분해"},
            {"+", "[]", "%", "[^]"},
            {"중첩 반복 조인","정렬 합병 조인","교차 조인","해시 조인"},
            {"로킹 기법","낙관적 검증 기법","타임 스탬프 기법","다중 버전 기법"},
            {"슈퍼키","대체키","기본키","외래키"},
            {"마름모","사각형","원","선"},
            {"뷰 위에 또 다른 뷰를 정의할 수 있다.","DBA는 보안성 측면에서 뷰를 활용할 수 있다.","필요한 정보를 요구에 맞게 가공하여 뷰를 만들 수 있다.","SQL을 사용하면 뷰에 대한 삽입,갱신,삭제 연산 시 제약사항이 없다."}
    };

    public static String correct_3[] = {
            "키 무결성",
            "논리적 데이터 모델",
            "Optimistic Validation",
            "이행적 함수 종속 제거",
            "%",
            "중첩 반복 조인",
            "다중 버전 기법",
            "슈퍼키",
            "원",
            "SQL을 사용하면 뷰에 대한 삽입,갱신,삭제 연산 시 제약사항이 없다."
    };


    public static String question_4[] = {
            "C언어에서 두 개의 논릿값 중 하나라도 틀리면 1을 모두 거짓이면 0을 반환하는 연산자는?",
            "개발 환경 구성을 위한 빌드 도구에 해당하지 않는 것은?",
            "다익스트라 알고리즘을 사용하는 라우팅 프로토콜에 대한 설명 중 올바르지 않은 것은?",
            "링크 상태 알고리즘을 적용하여 최단 경로를 찾는 라우팅 프로토콜은 무엇인가?",
            "개발 환경 구성을 위한 형상 관리 도구에 해당하지 않는 것은?",
            "Ping 유틸리티를 구현할 때 사용되는 네트워크 계층 프로토콜은 무엇인가?",
            "자신의 MAC은 알지만 IP를 모르는 경우 서버로부터 IP주소를 요청하기 위해 사용하는 프로토콜은?",
            "C언어에서 자료형 변환, 난수 발생, 메모리 할당 등의 함수를 제공하는 헤더 파일은?",
            "IPv4에서 IPv6로 전환하는 방법으로 가장 올바르지 않은 것은?",
            "리눅스/유닉스 명령어에 관한 설명으로 옳지 않은 것은?"
    };

    public static String answers_4[][] = {
            {"||", "&&", "**", "!="},
            {"Ant", "Kerberos", "Maven", "Gradle"},
            {"대규모 망에 적합한 알고리즘이다.", "거리벡터 알고리즘이다.", "OSPF에서 사용된다.", "링크상태 알고리즘이다."},
            {"RIP", "OSPF", "BGP", "IGRP"},
            {"Ant", "SVN", "CVS", "Git"},
            {"ARP","IGMP","ICMP","RPC"},
            {"Internet Protocol","Address Resolution Protocol","Internet Control Message Protocol","Reverse Address Resolution Protocol"},
            {"stdio.h","string.h","stdlib.h","math.h"},
            {"듀얼 스택 활용 전환","Backbone을 통한 VLAN 활용 전환","주소변환기 사용 전환","터널링 활용 전환"},
            {"모든 정보를 확인하는 명령어는 'uname-a'이다.","디렉토리의 퍼미션을 수정한느 명령어는 chmod이다.","특정한 파일을 찾는 명령어는 grep 이다.","파일의 내용을 화면에 출력하는 명령어는 cat이다."}
    };

    public static String correct_4[] = {
            "||",
            "논리적 데이터 모델",
            "Optimistic Validation",
            "OSPF",
            "Ant",
            "ICMP",
            "Reverse Address Resolution Protocol",
            "stdlib.h",
            "Backbone을 통한 VLAN 활용 전환",
            "특정한 파일을 찾는 명령어는 grep 이다."
    };

    public static String question_5[] = {
            "상향식 비용 산정 기법중 LOC기법에서 예측치를 구하기 위해 사용하는 항목이 아닌것은?",
            "DES는 몇 비트의 암호화 알고리즘인가?",
            "리눅스에서 생성된 파일 권한이 644일 경우 umask 값은?",
            "Python 기반의 웹 크롤링 프레임워크로 옳은 것은?",
            "데이터 저장 장치를 호스트 버스 어댑터에 직접 연결하는 스토리지 시스템은?",
            "비대칭 암호화 방식으로 소수를 활용한 암호화 알고리즘은?",
            "구글의 구글 브레인팀이 제작하여 공개한 기계학습을 위한 오픈소스 소프트웨어 라이브러리는?",
            "똑같은 패스워드들이 다른 암호 값으로 저장되도록 추가되는 값을 의미하는 것은?",
            "다른 컴퓨터의 취약점을 이용하여 스스로 전파하거나 메일로 전파되며 스스로를 증식하는 것은?",
            "조직 내에서 직무, 직책 등 개인의 역할에 따라 결정하여 부여하는 접근 정책은?"
    };

    public static String answers_5[][] = {
            {"낙관치", "기대치", "비관치", "모형치"},
            {"8", "16", "64", "132"},
            {"022", "666", "777", "755"},
            {"Li-fi", "Scrapy", "CrawlCat", "SBAS"},
            {"DAS", "NAS", "BSA", "NFC"},
            {"DES","AES","SMT","RSA"},
            {"타조","원 세그","포스퀘어","텐서플로"},
            {"Pass flag","Bucket","Opcode","Salt"},
            {"Worm","Rogue Ware","Adware","Reflection Attack"},
            {"RBAC","DAC","MAC","QAC"}
    };

    public static String correct_5[] = {
            "모형치",
            "64",
            "022",
            "Scrapy",
            "DAS",
            "RSA",
            "텐서플로",
            "Salt",
            "Worm",
            "RBAC"
    };
}
