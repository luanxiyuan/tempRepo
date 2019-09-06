export class TableRequest {

  // 检索关键字
  serchKey = '';
  // 排序列
  column = '';
  // 排序方式
  sort = 'desc';
  // 页数
  pageNumber = 1;
  // 页条数
  pageSize = 10;
  // 总条数
  count = 0;
  // 加载等待
  loading = true;
  // 页数选择器可选值
  pages: number[] = [10, 20, 30, 40, 50];
  // 部门id
  deptId: any;
  // 总页数
  pageCount = 0;
}
