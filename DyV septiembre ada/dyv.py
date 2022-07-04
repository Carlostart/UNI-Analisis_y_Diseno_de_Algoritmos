import numpy
import time

A1 = numpy.random.randint(
    low=-100, high=100, size=numpy.random.randint(low=1, high=100))
A1 = numpy.sort(A1)
A2 = numpy.random.randint(10, size=10)
A2 = numpy.sort(A2)

A3 = [1,  3, 31, 64, 88, 93, 96]


def DyV(A, inf, sup):
    med = (sup+inf)//2
    if sup <= inf:
        if A[sup] > sup:
            return (True, sup)
        return (False, -1)

    # print("inf ", inf, "   med ", med, "   sup ", sup)
    # print(A[inf:med+1], A[med+1:sup+1], sup-inf)
    if sup-inf <= 2:
        if A[med] <= med and A[med+1] > med+1:
            return (True, med+1)
        if sup-inf == 2:
            return DyV(A, inf+1, sup)
        return DyV(A, inf, inf)

    if A[med] <= med and A[med+1] > med+1:
        return (True, med+1)

    # print("izq")
    aux = DyV(A, inf, med)
    if aux[0]:
        return aux

    # print("der", med+1, sup)
    aux = DyV(A, med+1, sup)
    if aux[0]:
        return aux
    return (False, -1)


A = A1
print(A)
print(DyV(A, 0, len(A)-1))
