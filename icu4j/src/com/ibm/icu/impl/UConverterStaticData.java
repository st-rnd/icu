/**
*******************************************************************************
* Copyright (C) 2006, International Business Machines Corporation and    *
* others. All Rights Reserved.                                                *
*******************************************************************************
*
*******************************************************************************
*/ 
package com.ibm.icu.impl;

public final class UConverterStaticData {   /* +offset: size */
    public int structSize;                /* +0: 4 Size of this structure */
    
    public String name; /* +4: 60  internal name of the converter- invariant chars */

    public int codepage;               /* +64: 4 codepage # (now IBM-$codepage) */

    public byte platform;                /* +68: 1 platform of the converter (only IBM now) */
    public byte conversionType;          /* +69: 1 conversion type */

    public byte minBytesPerChar;         /* +70: 1 Minimum # bytes per char in this codepage */
    public byte maxBytesPerChar;         /* +71: 1 Maximum # bytes output per UChar in this codepage */

    public byte subChar[/*UCNV_MAX_SUBCHAR_LEN*/]; /* +72: 4  [note:  4 and 8 byte boundary] */
    public byte subCharLen;              /* +76: 1 */
    
    public byte hasToUnicodeFallback;   /* +77: 1 UBool needs to be changed to UBool to be consistent across platform */
    public byte hasFromUnicodeFallback; /* +78: 1 */
    public short unicodeMask;            /* +79: 1  bit 0: has supplementary  bit 1: has single surrogates */
    public byte subChar1;               /* +80: 1  single-byte substitution character for IBM MBCS (0 if none) */
    public byte reserved[/*19*/];           /* +81: 19 to round out the structure */
                                    /* total size: 100 */
    public UConverterStaticData()
    {
        subChar = new byte[UConverterConstants.MAX_SUBCHAR_LEN];
        reserved = new byte[19];
    }

    public UConverterStaticData(int structSize_, String name_, int codepage_, byte platform_, byte conversionType_, byte minBytesPerChar_, byte maxBytesPerChar_, byte[] subChar_, byte subCharLen_, byte hasToUnicodeFallback_, byte hasFromUnicodeFallback_, short unicodeMask_, byte subChar1_, byte[] reserved_)
    {
        structSize = structSize_;
        name = name_;
        codepage = codepage_;
        platform = platform_;
        conversionType = conversionType_;
        minBytesPerChar = minBytesPerChar_;
        maxBytesPerChar = maxBytesPerChar_;
        subChar = new byte[UConverterConstants.MAX_SUBCHAR_LEN];
        System.arraycopy(subChar_, 0, subChar, 0, (subChar.length < subChar_.length? subChar.length : subChar_.length));
        subCharLen = subCharLen_;
        hasToUnicodeFallback = hasToUnicodeFallback_;
        hasFromUnicodeFallback = hasFromUnicodeFallback_;
        unicodeMask = unicodeMask_;
        subChar1 = subChar1_;
        reserved = new byte[19];
        System.arraycopy(reserved_, 0, reserved, 0, (reserved.length < reserved_.length? reserved.length : reserved_.length));
    }

    public static final int sizeofUConverterStaticData = 100;
}

