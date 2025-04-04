function filterEmptyValues<T extends Record<string, unknown>>(obj: T): Partial<T> {
  return Object.keys(obj).reduce<Partial<T>>((acc, key) => {
    const k = key as keyof T;
    const value = obj[k];
    if (value !== "" && value !== null && value !== undefined) {
      acc[k] = value;
    }
    return acc;
  }, {});
}

export default filterEmptyValues;