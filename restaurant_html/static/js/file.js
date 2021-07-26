// 设置异步延迟间隔
export function delay (interval = 0) {
  return new Promise(resolve => {
    const timer = setTimeout(_ => {
      clearTimeout(timer)
      resolve()
    }, interval)
  })
}

// 按照二进制读取文件
// export function readFile (file) {
//   return new Promise(resolve => {
//     const reader = new FileReader()
//     reader.readAsBinaryString(file)
//     reader.onload = e => {
//       resolve(e.target.result)
//     }
//   })
// }
// readFile (file) {
//     // const reader = new FileReader()
//     // reader.readAsBinaryString(file)
//     // reader.onload = e => {
//     //   resolve(e.target.result)
//     // }
// }

readFile (){

}

// 字段对应表
export const character = {
  name: {
    text: '姓名',
    type: 'string'
  },
  number: {
    text: '编号',
    type: 'string'
  },
  sex: {
    text: '性别',
    type: 'number'
  },
  age: {
    text: '年龄',
    type: 'number'
  },
  role: {
    text: '角色',
    type: 'string'
  },
  phone: {
    text: '电话',
    type: 'string'
  },
  salary: {
    text: '月薪',
    type: 'number'
  },
  stay: {
    text: '状态',
    type: 'number'
  }
}

// 时间字符串格式化
export function formatTime (str, tpl) {
  const arr = str.match(/\d+/g).map(item => {
    return item.length < 2 ? '0' + item : item
  })
  tpl = tpl || '{0}年{1}月{2}日 {3}时{4}分{5}秒'
  return tpl.replace(/\{(\d+)\}/g, (_, group) => {
    return arr[group] || '00'
  })
}
