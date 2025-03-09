export default async function Edit(props: { params: Promise<{ id: string }> }) {
  const params = await props.params;
  const id = params.id;

  return <div>Edit { id}</div>;
}