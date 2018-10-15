package oc.p.chapters._6_ExceptionsAndAssertions.usingTryWithResources.tw._3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

class Q {

    void mRE() throws RE {
    }

    void mRE2() throws RE2 {
    }

    void mSQLE() throws SQLE {
    }

    void mFNFE() throws FNFE {
    }

    void mOld() {
        try {
            mRE();
            mRE2();
            mSQLE();
            mFNFE();
        } catch (RE e) {
//        }catch (RE2 e){  //RE which is superclass for RE2; has already been caught
        } catch (SQLE e) {
        } catch (FNFE e) {
        }
    }

    void mMultiCatch(){
        try{
            mRE();
            mRE2();
            mSQLE();
            mFNFE();
        }catch (/*RE2 |*/ RE | SQLE | /*FNFE |*/ IOException e){}
    }

    class RE extends RuntimeException {
    }

    class RE2 extends RE {
    }

    class SQLE extends SQLException {
    }

    class FNFE extends FileNotFoundException {
    }
}
