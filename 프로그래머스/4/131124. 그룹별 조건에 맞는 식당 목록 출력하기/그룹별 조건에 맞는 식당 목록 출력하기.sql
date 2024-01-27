-- 코드를 입력하세요
SELECT mp.MEMBER_NAME, RR.REVIEW_TEXT, date_format(rr.REVIEW_DATE, '20%y-%m-%d') as 'REVIEW_DATE'
from MEMBER_PROFILE mp left join REST_REVIEW RR
on mp.MEMBER_ID = RR.MEMBER_ID
# group by mp.MEMBER_NAME
# having count(MEMBER_NAME) = 3
where 1 =1
and mp.MEMBER_ID in (select MEMBER_ID 
                    from REST_REVIEW 
                    group by MEMBER_ID 
                    having count(MEMBER_ID) = (select count(MEMBER_ID) 
                                               from REST_REVIEW 
                                               group by MEMBER_ID 
                                               order by count(MEMBER_ID) desc 
                                               limit 1)
                    order by count(MEMBER_ID) desc)

order by rr.REVIEW_DATE, rr.REVIEW_TEXT
;


#select count(MEMBER_ID) from REST_REVIEW group by MEMBER_ID order by count(MEMBER_ID) desc limit;
# select MEMBER_ID 
# from REST_REVIEW 
# group by MEMBER_ID 
# having count(MEMBER_ID) = (select count(MEMBER_ID) 
#                            from REST_REVIEW 
#                            group by MEMBER_ID 
#                            order by count(MEMBER_ID) desc 
#                            limit 1)
# order by count(MEMBER_ID) desc