export default function Card({ className = null, children }: { className: string | null, children: React.ReactNode }) {
  return (
    <div className={`box-border rounded-md border-2 border-zinc-800 bg-zinc-900 p-3 shadow-sm hover:border-red-500 hover:shadow-md transition-all duration-200 ${className}`}>
      {children}
    </div>
  );
}