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
    print('len')
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
        print("-------------------")
        print(type(sqlLineArr))
        print("sqlLineArr len:")
        print(len(sqlLineArr))
        print("-------------------")
    return sqlLineArr


def generateSql(sqlTemplateName, custInfoList, productInfoList):
    sqlTemplateFile = sqlTemplatePath + '//' + sqlTemplateName + '.json'
    with open(sqlTemplateFile, mode='r', encoding='UTF-8') as f:
        data = json.load(f)
        tableName = tablename=data['TABLE']
        delSqlLine = delSql.format(tablename=tableName) + '\n'

        cols = data['COLS']

        sqlArr = []
        sqlArr.extend(copyArr(custInfoList, cols))
        tempArr = []
        for sqlItem in sqlArr:
             copyArr(productInfoList, sqlItem)
             tempArr.extend(copyArr(productInfoList, sqlItem))
    print(generateSqlLine(tempArr, tableName))
    print([delSqlLine].extend(generateSqlLine(tempArr, tableName)))
    print([delSqlLine].extend(generateSqlLine(tempArr, tableName)))
    return [delSqlLine].extend(generateSqlLine(tempArr, tableName))


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
            print("templateArrLen:")
            print(len(generateSql(template,data['custInfoList'], data['productInfoList'])))
            print(templateArr)
            sqlArr.extend(templateArr)
        writeToFile(data['fileName'], sqlArr)
    print('generate succ')


generate(sqltemplate)