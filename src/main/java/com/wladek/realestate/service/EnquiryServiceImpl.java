package com.wladek.realestate.service;

import com.wladek.realestate.domain.realestate.Enquiry;
import com.wladek.realestate.repository.EnquiryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wladek on 1/14/16.
 */
@Service
public class EnquiryServiceImpl implements EnquiryService {
    @Autowired
    EnquiryRepo enquiryRepo;

    @Override
    public Enquiry make(Enquiry enquiry) {
        return null;
    }

    @Override
    public Enquiry findOne(Long id) {
        return null;
    }
}
