package com.wladek.realestate.service;

import com.wladek.realestate.domain.realestate.Enquiry;

/**
 * Created by wladek on 1/14/16.
 */
public interface EnquiryService {
    public Enquiry make(Enquiry enquiry);
    public Enquiry findOne(Long id);
}
