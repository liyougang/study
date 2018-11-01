def convertStr(str):
    if str.strip() == 'null':
        return '\"\"'
    return '\"' + str.strip() + '\"'
str = '''201810291411562742591, null,64955,1002978568,HB000A001,2017022201452324,A,PE0058,YNJF,10000323165568,4,20150708, 1000000.00000, 1000000.00000, 0.00000, 0.00000,20150708,3,新方程-启辰海归2期基金-5,31-10月-18 05.55.51.000000 下午,29-10月-18 02.11.56.336000 下午, null'''

arr = str.split(',')
print(arr)

s = '''BOOKS_DTL_NO,SUBMIT_DEAL_NO,EXT_VOL_DTL_NO,TX_ACCT_NO,DIS_CODE,CP_ACCT_NO,FUND_SHARE_CLASS,FUND_CODE,TA_CODE,PROTOCOL_NO,PROTOCOL_TYPE,REG_DT,BALANCE_VOL,AVAIL_VOL,FRZN_VOL,JUST_FRZN_VOL,OPEN_REDE_DT,PRODUCT_CHANNEL,PRODUCT_NAME,UPDATE_DTM,CREATE_DTM,ACK_DT'''
colArr = s.split(",")
print(colArr)

print(len(colArr))
print(',')
print(len(arr))

zip(colArr, arr)

for m, n in zip(colArr, arr):
    print(convertStr(m) + ':' + convertStr(n) + ',')

