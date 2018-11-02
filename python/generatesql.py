import json
import time

s = """insert into {tablename} ({cols})
values ({values});"""

delSql = """delete {tablename};"""

sqlTemplatePath = 'D://sqldata//template'
generateSqlPath = 'D://sqldata//sql'
sqltemplate = sqlTemplatePath + '//'+'sqltemplate.json'

def copyArr(replaceArr, src):

    sqlArr = []
    print(len(replaceArr))
    if len(replaceArr) > 0:
        for replaveVal in replaceArr:
            newCols = {}
            for key, value in src.items():
                newCols[key] = value
                if replaveVal.__contains__(key):
                    newCols[key] = replaveVal[key]
            sqlArr.append(newCols)
    return sqlArr


def generateSqlLine(sqlArr, tableName):
    sqlLineArr = []
    for sqlItem in sqlArr:
        colNames = sqlItem.keys()
        colVals = sqlItem.values()

        cols = ','.join(colNames)
        arr = []
        for val in colVals:
            arr.append("'" + val.strip() + "'")
        values = ','.join(arr)
        sqlLine = s.format(tablename=tableName, cols=cols, values=values) + '\n'
        sqlLineArr.append(sqlLine)
    return sqlLineArr


def generateSql(sqlTemplateName, custInfoList, productInfoList):
    sqlTemplateFile = sqlTemplatePath + '//' + sqlTemplateName + '.json'
    sqlArr = []
    tempArr = []
    with open(sqlTemplateFile, mode='r', encoding='UTF-8') as f:
        data = json.load(f)
        tableName = data['TABLE']
        delSqlLine = delSql.format(tablename=tableName) + '\n'

        cols = data['COLS']
        sqlArr.extend(copyArr(custInfoList, cols))

        for sqlItem in sqlArr:
             copyArr(productInfoList, sqlItem)
             tempArr.extend(copyArr(productInfoList, sqlItem))

    tt = generateSqlLine(tempArr, tableName)
    testArr = [delSqlLine]
    print([].extend(tt))
    testArr.extend(tt)
    return testArr


def writeToFile(fileName, arr):
    timeStr = time.strftime("%Y%m%d%H%M%S", time.localtime())
    fileName = generateSqlPath + '//' + timeStr + '_' + fileName + '.sql'
    with open(fileName, mode='w', encoding='UTF-8') as f:
        f.writelines(arr)


def generate(sqltemplate):
    print('generate start')
    sqltemplate = sqltemplate
    with open(sqltemplate, mode='r', encoding='UTF-8') as f:
        data = json.load(f)
        sqlArr = []
        templateArr = []
        for template in data['templates']:
            templateArr = generateSql(template,data['custInfoList'], data['productInfoList'])
            print("templateArrLen:-----")
            print('test')
            templateArr1 = generateSql(template,data['custInfoList'], data['productInfoList'])
            print("templateArr1:")
            print(templateArr1)
            print('---test')
            print(templateArr)
            sqlArr.extend(templateArr)
            print("------templateArrLen:-----")
        writeToFile(data['fileName'], sqlArr)
    print('generate succ')


generate(sqltemplate)