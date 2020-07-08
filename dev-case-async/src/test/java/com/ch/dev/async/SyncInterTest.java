package com.ch.dev.async;

import org.junit.Assert;
import org.junit.Test;

public class SyncInterTest {

    private SyncInter syncInter = new SyncInterImpl();

    @Test
    public void Given_hb_true_When_detect_hb_finish_Then_return_hb_success(){
        //Given
        String hbInfo = "id1";

        //When
        boolean hbResult = syncInter.detectHb(hbInfo);

        //Then
        Assert.assertTrue(hbResult);
    }

    @Test
    public void Given_hb_false_When_detect_hb_finish_Then_return_hb_failed(){
        //Given
        String hbInfo = "id2";

        //When
        boolean hbResult = syncInter.detectHb(hbInfo);

        //Then
        Assert.assertFalse(hbResult);
    }

    @Test
    public void Given_hb_null_When_detect_hb_finish_Then_return_hb_failed(){
        //Given
        String hbInfo = "";

        //When
        boolean hbResult = syncInter.detectHb(hbInfo);

        //Then
        Assert.assertFalse(hbResult);
    }

    @Test
    public void Given_hb_cant_find_When_detect_hb_finish_Then_return_hb_failed(){
        //Given
        String hbInfo = "111";

        //When
        boolean hbResult = syncInter.detectHb(hbInfo);

        //Then
        Assert.assertFalse(hbResult);
    }
}
