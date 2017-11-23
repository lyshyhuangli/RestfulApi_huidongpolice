package com.api.common;

public enum StaticNumber
{
    ZERO(0),

    ONE(1),

    TWO(2),

    THREE(3),

    FOUR(4),

    FIVE(5),

    SIX(6),

    SEVEN(7),

    EIGHT(8),

    NINE(9),

    TEN(10),

    ELEVEN(11),

    TWELVE(12),

    THIRTEEN(13),

    FOURTEEN(14),

    FIFTEEN(15),

    SIXTEEN(16),

    SEVENTEEN(17),

    EIGHTEEN(18),

    NINETEEN(19),

    TWENTY(20),

    TWENTY_ONE(21),

    TWENTY_TWO(22),

    TWENTY_THREE(23),

    TWENTY_FOUR(24),

    TWENTY_FIVE(25),

    TWENTY_SIX(26),

    TWENTY_SEVEN(27),

    TWENTY_EIGHT(28),

    TWENTY_NINE(29),

    THIRTY(30),

    THIRTY_ONE(31),

    THIRTY_TWO(32),

    THIRTY_FIVE(35),

    FIFTY(50),

    FORTY_THREE(43),

    FIFTY_FIVE(55),

    SIXTY(60),

    EIGHTY(80),

    NINETY(90),

    HASH_COMPUTE_NUMBER(61),

    HASH_RESULT(17),

    HASH_GENE(37),

    ONE_HUNDRED(100),

    TWO_HUNDRED(200),

    FIVE_HUNDRED(500),

    TWO_THOUSAND(2000);

    private int code;

    private StaticNumber(int code)
    {
        this.code = code;
    }

    public int getCode()
    {
        return this.code;
    }
}
